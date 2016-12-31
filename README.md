# HearthIntellect

[![Build Status](https://travis-ci.org/AlphaHearth/HearthIntellect.svg?branch=master)](https://travis-ci.org/AlphaHearth/HearthIntellect)

Hearthstone database website written in Java and pure [Spring](http://spring.io/).

## Future tasks

- [x] Update `crawler` module to support the latest [HearthHead](http://www.hearthhead.com/) web site.
- [x] Add test cases for `CardRepository` and `MechanicRepository`.
- [x] Migrate from Jersey to SpringMVC.
- [x] Deploy version `0.1`.
- [ ] Migrate from Morphia to Spring Data.
- [ ] Add `insertAll` and `updateAll` methods for `Card`, `Mechanic` and `Patch`.
- [ ] Implement text searching on card name.
- [ ] Implement `UserController`.
- [ ] Add test cases for `PatchRepository`.
- [ ] Implement `MechanicController` and `PatchController`.
- [ ] Implement user authentication and authorization framework using Spring Security.
- [ ] Implement Admin interfaces.
- [ ] Use Admin interface to populate `Mechanic` and `Patch` data.
- [ ] Implement advanced filtering for Card browsing.
- [ ] Deploy version `0.2`.
- [ ] Update `Card` model to support Wild mode, Arena mode and Standard mode.
- [ ] Add controller classes for `Deck`.
- [ ] Deploy version `0.3`.

## Technologies

- Spring for Dependency Injection.
- Spring MVC for RESTful API.
- Spring Security for User Authentication and Authorization.
- Spring Data, MongoDB Java Driver and MongoDB for Non-relational Data Persistence.