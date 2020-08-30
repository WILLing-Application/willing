$(document).ready(function () {
    $('#ownerMatrix').DataTable({
        "scrollX": true,
        "scrollY": 200,
        // "scrollY": true,
    });
    $('.dataTables_length').addClass('bs-select');
});

$('#awardButton').click(function() {
    $('input[name=items]').prop('checked', false);
    $('input[name=users]').prop('checked', false);
});