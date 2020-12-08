Meta:

Narrative:
As a Miro user
I want to create stickers, visible to other users
To facilitate better collaboration


Scenario: create a board and a sticker as Rick

Given a shared board 'Board' is created
And user Rick logs in
And the board is opened by View Link
When the user creates a sticker from the widget toolbar
Then screenshot is taken

Scenario: join the board as Morty and check the sticker is displayed

Given user Morty logs in
When the user opens the board via View Link
Then screenshot is taken