# WILLing

* Remember to work on branches for pull requests

---

## GLOSSARY

Visitor: visits landing page, signup page.

User: a registered user, can login and view albums to which they've been invited by an owner.

Owner: a registered user, can create and manage an album of items, can invite users to register, can allow users access to view their albums.

Feature: (curriculum) a component of the program that performs a specific function for the user

---

## USER STORIES

1.	Visitors can view a landing page with a description of the service and register to create an account.
2.	Visitors can respond to emailed invitations to register for an account, in order to view the Owner’s "album" and listed items (after being given access by the Owner).
3.	Upon registering successfully by entering account details (username, password, email, name, address, phone#), the User is directed to the view page. (Optionally display a welcome message.)
4.	Users can CRUD their own User information (username, password, email, name, address, phone#).
5.	Users can view and search listed albums and items by keyword, from the albums they have been given access to.
6.	Users can "bid" on item(s) by indicating their interest, by selecting a ranking from 1 (may be interested) to 5 (very interested).
7.	Owners (a user who created/owns an album), can CRUD their own album(s) with title, description, lineage, deadline for responses, upload photo(s) and video(s).
8.	Owners (a user who created/owns an album), can CRUD their album's items, with title, description, lineage, upload photo(s) and video(s).
9.	Owners (a user who created/owns an album), can invite a list of people by email to visit the site by clicking on a link, which takes them to the registration/sign up page.
10.	Owners (a user who created/owns an album), can view a list of email invites sent, with the name of any registered user with a matching email address. The Owner can select the matching user to enable access.
11.	Owners (a user who created/owns an album), can view a dashboard with summary information by album: <br>
A.	a grid/matrix of items and users, with color-coded interest ranking <br>
B.	a list by item with a count of interested users, click to list the interested users for an item <br>
C.	a list by users associated with the owner’s album(s), with a count of items "bid" on/interested in, click to list the items for a user <br>

---

## FEATURE LIST 
### (Core functionality) 
##### Cross-referenced features to user-story#

*	Landing page with information describing the application, and a call to action (sign up). 1 
*	Registration/signup page to create an account (sign up). 1 
*	Upon successful signup and/or login, direct the user to the view page (optionally display a welcome message). 3
*	Dynamic navbar for login/logout and user roles (user vs. user/owner vs. admin) options. 3
*	Lock down the user profile page, allow the user to CRUD their own user account details. 4
*	Allow users to view the albums and listed items they have access to. 5 
*	Search functionality that allows users to search in the albums and listed items they have access to, by title, description, and/or lineage. 5
*	Indicate interest in an item by ranking it from low (1) to high (5), and save the user’s interest ranking# in the database. 6
*	Create an Album view page with links to each individual Album page. 7 
*	Allow the user/owner to create, update and delete albums. 7
*	Create an Item index page with links to each individual Item page. 8
*	Allow the user/owner to create, update and delete items. 8 
*	Implement the Filestack API for uploading photos and videos. 7, 8
*	Allow uploading photos and videos to albums and items. 7, 8
*	Create an email invitation associated with an album, allow owner to enter a list of email addresses to send the invitation to. The link in the email is to the registration/signup page. 9
*	Create a view to list the email invites sent, and the name of any registered user with a matching email address. The owner can select the matching user to enable access to that album. 10
*	Create an admin/owner dashboard with color-coded summary info by album. 11, A/B/C

---

### Extra Features (Optional functionality)

##### Users
 
*	can comment on an item or reply to a comment.
*	can indicate if they are willing to pay shipping costs, if applicable.
*	can opt in to enable SMS text, and opt in/out of each type of notification:
1.	a new item added to an album.
2.	an item "won" (awarded to them).
3.	a new comment on an item they are interested in.
4.	a change in status on an item they are interested in.
5.	a new direct message in the application.
*	can upload an image for their profile photo.
*	can request a forgotten username or a password reset and receive an email.
*	can pay an invoice for shipping costs.

##### Owners (a User who owns an album)

*	can see invite history.
*	can send or re-send invitation(s) to individuals or groups, as needed.
*	can mark an item as "awarded" to a user, from the item listing and/or the dashboard matrix:
1.	available/awarded status is shown on the item listing.
2.	awarded status is shown on the color-coded dashboard matrix, marked with a symbol.
3.	an email is sent to the awarded user.
4.	an email is sent to the interested users who were not awarded.
*	can mark an item as "pick-up only".
*	can add estimated shipping costs to an item, if applicable.
*	can invoice a user for payment of shipping costs (total for multiple awarded items).

##### Admins

*	can CRUD all users, albums, and items.
*	can grant admin privileges to another user.
*	can create email message templates for use when messaging user(s).
*	can create SMS text message templates for use when messaging user(s).
*	can privately message a user or groups of users.

---
---

## URL METHODS MAP

#### Models (Beans):
	
* Album
* User -	May be a guest user and/or an owner	
* Item
* Image
* Interest
* Invite
* Comment - optional feature
* Admin - optional feature (add separate admins table/model with FK to user_id for admin users with top-level access to CRUD everything (for developers/application support)

---

#### Views (before Login)

| URL       | Description   | Navbar Name      | Thymeleaf template |
| :---      | :---          | :---             | :---               |
| /home     | Landing page  | Home or Brand    | users/home.html    |
| /sign-up  | default       | Sign Up          | users/sign-up.html |
| /login    | default       | Login            | users/login.html   |
| /devs     | Developers/About | Developers    | devProfile.html    |

#### Views (after Login)

| URL       | Description   | Navbar Name      | Thymeleaf template |
| :---      | :---          | :---             | :---               |
| /home     | same as before  | Home or Brand  | same as before login |
| /view     | View page     | Browse           | albums.html        |
| /view/interests | View (filtered) | Interests | albums.html (?)   |
| /create   | Create new     | Create          | ?
| /devs     | same as before | Developers      | same as before login |
| /profile  | User profile  | Account/icon/photo (optional) | profile.html |
| /logout   | default       | Logout           | part of navbar     |

* NOTE - there will be more individual show/edit/delete pages. May need to be individual album/create and item/create pages, but would like to combine onto one page.

---

## METHODS

(Under constructions... work in progress)

Methods	 Urls	 Actions	 Filename - wireframes (rough)
GET	 /index	 Landing page	Landing Page.jpg
GET/POST	 /sign-up	 register for new account	Default page
GET/POST	 /login	 login to user account	Default page
GET	/view	 Browse nav - view list (owner, albums, items), Filtered Interests view	WILLing Album View.pdf, WILLing Items Views.pdf, Pending new
GET	/albums/{id}	Album detail	
GET/POST	/albums/{id}/edit	edit & delete Album (owner)	
GET/POST	/albums/{id}/delete	delete Album (owner)	
GET	/items/{id}	Item detail	WILLing Items Views.pdf
GET/POST	/items/{id}/edit	edit Item (owner)	WILLing Items Views.pdf
GET/POST	/items/{id}/delete	delete Item (owner)	WILLing Items Views.pdf
GET	/profile	view user info (User), view dashboard (Admin)	WILLing Dashboard Album View.pdf, AdminMatrix and UserCrudPage.pdf
GET/POST	/profile/edit	User edit & delete (self)	AdminMatrix and UserCrudPage.pdf
GET/POST	/profile/delete	User delete account (self)	AdminMatrix and UserCrudPage.pdf


---

## SECURITY AND PROFILE DASHBOARD EXAMPLES

##### Profile (everyone) - User account info (CRUD)				

--- 

##### Profile (Owner) - dashboard

Matrix: 
A grid layout referencing Items to Users (see wireframe)
				
Users list:

| Username  | First Name  | Last Name | #Interested (items) |
| :---      | :---        | :---      | :--- |
| kjohnson  | Kim         | Johnson   | 1    |
| ljames    | Leroy       | James     | 10   |
				
Albums list:

| Album title	| Item Title	      | #Interested (users) |
| :---          | :---                | :--- |
| Uncle Joe     | Cornhusker tool     | 1 |
| Grandma Sue   | China dishes        | 5 |
