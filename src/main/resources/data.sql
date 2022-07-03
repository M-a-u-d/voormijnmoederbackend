INSERT INTO gebeurtenissen (datum, id, naam, naamwaar, opmerking, organisator, straat, woonplaats) VALUES ('Woensdagmiddag', 1, 'bridgen', 'in de kroeg bij  de kerk', 'met borrel erna', 'BridgeKing', 'Dorpsstraat 1', 'Zandvoort');
INSERT INTO gebeurtenissen (datum, id, naam, naamwaar, opmerking, organisator, straat, woonplaats) VALUES ('dinsdagochtend', 2, 'kofffie', 'bij tante leen', 'appelgebakje erbij?', 'tante Lenie', 'zuiderZeestraat 1', 'Zandvoort');
INSERT INTO gebeurtenissen (datum, id, naam, naamwaar, opmerking, organisator, straat, woonplaats) VALUES ('vrijdagochtend', 3, 'Yoga voor senioren', 'strandtent Hippie Fish', 'vergeet je matje niet', 'soepele Oma', 'zeestraat 12', 'Zandvoort');
INSERT INTO gebeurtenissen (datum, id, naam, naamwaar, opmerking, organisator, straat, woonplaats) VALUES ('woensdag', 4, 'haken', 'in de kroeg bij  de kerk', 'met borrel erna', 'hookie hetty', 'Dorpsstraat 1', 'Zandvoort');
INSERT INTO gebeurtenissen (datum, id, naam, naamwaar, opmerking, organisator, straat, woonplaats) VALUES ('vrijdagmiddag', 5, 'Vrijmibo gepensioneerden', 'Strandtent De Haven', 'Ook al werk je niet meer Borrelen is nog altijd leuk', 'HR Harry', 'zeestraat 5', 'Zandvoort');

INSERT INTO Users (username, id, phone,apikey,birthdate,email,enabled,name,password) VALUES ('jeroen', 1,0622908592,'W4qh1Fe0dep4iR9YDyr0',NULL,'j@powerrr.nl',True,NULL,'$2a$10$4IVGjjqmPWFypMTfXb/t.eFxQX/6swCJDUyP3h3yPtrbrAzImlGEK');
INSERT INTO Users (username, id, phone,apikey,birthdate,email,enabled,name,password) VALUES ('maud',2,NULL,'OMWtwlprF0YTcdReyntE',NULL,'m@powerrr.nl',True,NULL,'$2a$10$0EwezMOIhWQ2K9X2B3WpO.Oid6PeWT54r9lKxYiJT4cDogByGsReC');

INSERT INTO authorities (authority, username) VALUES ('ROLE_ADMIN', 'maud');
INSERT INTO authorities (authority, username) VALUES ('ROLE_ADMIN', 'jeroen');

INSERT INTO gebeurtenis_en_user (gebeurtenis_naam, user_username, datum_aangemeld) VALUES ('bridgen', 'jeroen', null);