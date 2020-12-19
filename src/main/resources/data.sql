INSERT INTO CHARACTER (name,description,modified) VALUES ('Character1', 'Character1 description', CURRENT_TIMESTAMP);
INSERT INTO COMIC(description,digital_id,format,issue_number,modified,title,character_id) VALUES ('Comic description #810',810,'COMIC',4890,CURRENT_TIMESTAMP,'Comic 810',1);
INSERT INTO COMIC(description,digital_id,format,issue_number,modified,title,character_id) VALUES ('Comic description #538',538,'TRADE_PAPERBACK',2739,CURRENT_TIMESTAMP,'Comic 538',1);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #810','Event 810',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,1);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #538','Event 538',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,1);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #253','Event 253',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,1);
INSERT INTO CHARACTER (name,description,modified) VALUES ('Character2', 'Character2 description', CURRENT_TIMESTAMP);
INSERT INTO COMIC(description,digital_id,format,issue_number,modified,title,character_id) VALUES ('Comic description #540',540,'GRAPHIC_NOVEL',4762,CURRENT_TIMESTAMP,'Comic 540',2);
INSERT INTO COMIC(description,digital_id,format,issue_number,modified,title,character_id) VALUES ('Comic description #588',588,'DIGITAL_COMIC',3113,CURRENT_TIMESTAMP,'Comic 588',2);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #540','Event 540',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,2);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #588','Event 588',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,2);
INSERT INTO EVENT(description,title,start,end,modified,character_id) VALUES ('Event description #235','Event 235',CURRENT_DATE,CURRENT_DATE,CURRENT_TIMESTAMP,2);
