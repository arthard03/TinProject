INSERT INTO Guild (description, members, name) VALUES
('A powerful guild of warriors', 50, 'The Iron Fist'),
('A secretive guild of mages', 25, 'The Arcane Circle'),
('A brotherhood of assassins', 15, 'The Dark Hand'),
('A guild of merchants and traders', 100, 'The Gold Coin'),
('A guild of thieves and rogues', 30, 'The Nightingales');
INSERT INTO Player (clazz, name, persuasion_level, speciality) VALUES
('Warrior', 'Arthur', 10, 'Swordsmanship'),
('Mage', 'Elara', 8, 'Fire Magic'),
('Rogue', 'Serana', 12, 'Stealth'),
('Archer', 'Falmer', 9, 'Marksmanship'),
('Battlemage', 'Jzargo', 7, 'Destruction Magic');
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id) VALUES
('Defeat the goblin king', 'Hard', 1000.00, 1, 1),
('Find the stolen artifact', 'Medium', 500.00, 0, 2),
('Hunt the elusive vampire lord', 'Very Hard', 2000.00, 0, 3),
('Protect the caravan from bandits', 'Easy', 250.00, 1, 4),
('Retrieve the Dragonstone from the Dwemer ruins', 'Legendary', 5000.00, 0, 5);
INSERT INTO Bounty_claim (claim_date, finish_date, bounteis_bounty_id, player_id) VALUES
('2023-11-23 10:30:00', '2023-11-25 15:00:00', 1, 1),
('2023-12-01 12:00:00', '2023-12-05 18:00:00', 2, 2),
('2023-12-10 09:00:00', '2023-12-18 17:00:00', 3, 3),
('2023-11-28 14:00:00', '2023-11-30 16:30:00', 4, 4),
('2023-12-03 11:30:00', '2023-12-12 20:00:00', 5, 5);