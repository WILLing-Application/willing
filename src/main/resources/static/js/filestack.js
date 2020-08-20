(function () {
    console.log("hello world");
    const client = filestack.init(FILESTACK_API_KEY);
    let urlArray = [];
    let fileTypeArray = [];
    document.getElementById("upload").addEventListener("click", (e) => {
        e.preventDefault();
        const options = {
            imageMax: [400, 400],
            maxFiles: 10,
            onUploadDone: res => {
                for (let i = 0; i < res.filesUploaded.length; i++) {
                    urlArray.push(res.filesUploaded[i].url);
                    fileTypeArray.push(res.filesUploaded[i].originalFile.type);
                }
                let photosHtml = "";
                let videosHtml = "";
                for (let i = 0; i < urlArray.length; i++) {
                    if (fileTypeArray[i] === "image/jpeg") {
                        photosHtml += `
                        <img src="${urlArray[i]}" alt="" class="mb-3">
                        <br>
                        `;
                    } else if (fileTypeArray[i] === "video/mp4") {
                        videosHtml += `
                        <video width="400" height="400" controls>
                            <source src="${urlArray[i]}">
                        </video>
                        <br>
                        `;
                    }
                }
                let photoAndVideos = photosHtml + videosHtml;
                $("#images").val(urlArray);
                $("#file-type").val(fileTypeArray);
                $("#files").html("<h3>Your uploaded files:</h3><br>" + photoAndVideos);
            }
        };
        client.picker(options).open();
    });
})();