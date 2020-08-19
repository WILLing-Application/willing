# willing

* Remember to work on branches for pull requests

=====================
GLOSSARY

visitor: visits landing page, signup page

user: a registered user, can view albums to which they've been invited by an owner

owner: created and manages an album of items to dole out to invited users

guest: ? dunno if we need this. see user.

feature:(curric) a component of the program that performs a specific function for the user



=====================
User Stories:

Visitors can view a landing page with a description of the service, and register to create an "owner" account.

	•	Visitors can view a landing page with a description of the service, and register to create an "owner" account.
	•       Visitors can respond to emailed invitations to view the "album" and listed items they have access to.
	•	Visitors can register to create an account as an invited guest, and enter their account details.
	•	Visitors can register to create an account as an admin/owner, and enter their account details.
	•	Guests can login and CRUD their own user information (username, password, email, name, address, phone#).
	•	Guests can search listed items by keyword.
	•	Guests can favorite item(s),
	•	Guests can "bid" on item(s) by indicating their interest, and ranking it from 1 (maybe interested) to 5 (very interested).
	•	Admin/Owners can login and CRUD their own and their invited users information.
	•	Admin/Owners can login and CRUD their own album(s) with title, description, deadline for responses, upload photo(s) and video(s).
	•	Admin/Owners can CRUD their album's items, with title, description & lineage, upload photo(s) and video(s).
	•	Admin/Owners can invite a list of users by email to view an album by clicking on a link.
	•	Admin/Owners can view a dashboard with summary information by album:
	•	a grid/matrix of items and guests, with color-coded ranking
	•	a list by item with a count of interested guests, click to list the interested guests for an item
	•	a list by guest with a count of items "bid" on, click to list the items for a guest


======================
FEATURE LIST (Core functionality) Cross-referenced features to user-story#

	•	Landing page with information describing the application and a call to action (sign up).1 
	•	Direct invited guests (authenticate they were invited) to invited album(s) and permit them to view albums and listed items only. Prompt them to register as a guest for any interaction beyond viewing allowed pages.2 (Should this be out-of-scope? No idea how hard this is… Use JWT?)
	•	Register users and login/logout authorization, as invited guest/user.3
	•	Register users and login/logout authorization, as owner/admin.4
	•	Dynamic navbar for logged in users and guests vs admin/owner.3,4
	•	Lock down the user profile page to the authorized user, allow CRUD.5
	•	Search functionality that allows users to search in the albums and listed items they have access to, by title, description, and/or lineage.6
	•	Mark an item as favorite, (visual indicator) and save the users’ favorite status in the database.7
	•	Indicate interest in an item (visual indicator) and rank it from low (1) to high (5), and save the user’s indicator and ranking# in the database.8
	•	List users (related to the owner’s albums) on the admin/owner profile page, allow CRUD on “their” users.9
	•	Create an Album index page with links to each individual Album page.10 (Or put on profile page?)
	•	Allow the admin/owner to create, update and delete albums.10
	•	Create an Item index page with links to each individual Item page.11
	•	Allow the admin/owner to create, update and delete items.11 
	•	Allow uploading photos and videos to albums and items.10, 11
	•	Create an invitation associated with an album, create a list of email addresses to send the invitation to. The link in the email gives read-only access to the album and items in it.12
	•	Create an admin/owner dashboard with color-coded summary info by album.13
	

======================
(Optional functionality/extra features)

Users
 
	•	can comment on an item or reply to a comment.
	•	can create their notification preferences, for email and/or SMS text, and opt in/out of each type of notification:
	•	a new item added to an album.
	•	an item "won" (awarded to them).
	•	a new comment on an item they follow.
	•	a change in status on an item they follow.
	•	a new direct message in the application.
	•	can upload an image for their profile photo.
	•	can indicate if they are willing to pay shipping costs, if applicable.
	•	can pay an invoice for shipping costs.
Admins

	•	can see invite history.
	•	can send or re-send invitation(s) to individuals or groups, as needed.
	•	can grant admin privileges to another user.
	•	can mark an item as "pick-up only".
	•	can add estimated shipping costs to an item, if applicable.
	•	can mark an item as "awarded" to a user, from the item listing and/or the dashboard matrix:
	•	available/awarded status is shown on the item listing.
	•	awarded status is shown on the color-coded dashboard matrix, marked with a symbol.
	•	an email is sent to the awarded user.
	•	an email is sent to the interested users who were not awarded.
	•	can privately message a user or groups of users.
	•	can create email message templates for use when messaging user(s).
	•	can invoice a user for payment of shipping costs (total for multiple awarded items).


=====================
URL METHODS MAP

-------------
Models (Beans):
-------------
		
Album		
User -	Both a guest user and/or an owner	
Item		
Image		
Interest		
Invite		
Comment		
Admin -	optional feature -	If we finish early, 
                            could add an admins table 
                            containing user_ids of users who 
                            have access to everything (developers)

-------------
Views before Login		Navbar Name
-------------

/home	Landing page	Home or Brand

/sign-up	default Spring Security	Sign Up

/login	default Spring Security	Login

/developers	Developers view	Developers

Views after Login		Navbar Name

/home	Landing page	Home or Brand

/view	View page	Browse

/interests	View page (Filtered)	Interests

/developers	same as above	Developers

/profile	User profile page 	User Account / person symbol or profile pic (optional feature)

/logout	default Spring Security	Logout

    *NOTE - there will be more for individual create item and album pages
    *NOTE - original notes: there will be more individual show/edit/delete pages
    

------------
METHODS
------------
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


-----------
SECURITY AND EXAMPLES
-----------

Profile - everyone				
User account info (CRUD)				
				
Owner profile - dashboard				
(matrix)	grid layout			
				
(users list)	Username	First Name	Last Name	#Interested items
	Kathy	Kathy	Davis	1
	Bob	Bob	Davis	10
				
(albums list)	Album title	Item Title	????	#Interested Users
1	Uncle Joe	Lamp		1
2	Grandma Sue	Couch		5