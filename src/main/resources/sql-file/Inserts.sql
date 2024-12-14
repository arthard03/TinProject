INSERT INTO Guild (description, members, name, guildid)
SELECT 'A powerful guild of warriors', 50, 'The Iron Fist', 1
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 1);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A secretive guild of mages', 25, 'The Arcane Circle', 2
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 2);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A brotherhood of assassins', 15, 'The Dark Hand', 3
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 3);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A guild of merchants and traders', 100, 'The Gold Coin', 4
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 4);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A guild of thieves and rogues', 30, 'The Nightingales', 5
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 5);
INSERT INTO Player (clazz, name, persuasion_level, speciality, id)
SELECT 'Warrior', 'Arthur', 10, 'Swordsmanship', 1
    WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 1);
INSERT INTO Player (clazz, name, persuasion_level, speciality, id)
SELECT 'Mage', 'Elara', 8, 'Fire Magic', 2
    WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 2);
INSERT INTO Player (clazz, name, persuasion_level, speciality, id)
SELECT 'Rogue', 'Serana', 12, 'Stealth', 3
    WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 3);
INSERT INTO Player (clazz, name, persuasion_level, speciality, id)
SELECT 'Archer', 'Falmer', 9, 'Marksmanship', 4
    WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 4);
INSERT INTO Player (clazz, name, persuasion_level, speciality, id)
SELECT 'Battlemage', 'Jzargo', 7, 'Destruction Magic', 5
    WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 5);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A guild of thieves and rogues', 30, 'The Nightingales', 5
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 5);
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id, bountyid)
SELECT 'Defeat the goblin king', 'Hard', 1000.00, 1, 1, 1
    WHERE NOT EXISTS (SELECT 1 FROM Bounties WHERE bountyid = 1);
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id, bountyid)
SELECT 'Find the stolen artifact', 'Medium', 500.00, 0, 2, 2
    WHERE NOT EXISTS (SELECT 1 FROM Bounties WHERE bountyid = 2);
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id, bountyid)
SELECT 'Hunt the elusive vampire lord', 'Very Hard', 2000.00, 0, 3, 3
    WHERE NOT EXISTS (SELECT 1 FROM Bounties WHERE bountyid = 3);
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id, bountyid)
SELECT 'Protect the caravan from bandits', 'Easy', 250.00, 1, 4, 4
    WHERE NOT EXISTS (SELECT 1 FROM Bounties WHERE bountyid = 4);
INSERT INTO Bounties (description, difficulty, reward, status, guild_guild_id, bountyid)
SELECT 'Retrieve the Dragonstone from the Dwemer ruins', 'Legendary', 5000.00, 0, 1, 5
    WHERE NOT EXISTS (SELECT 1 FROM Bounties WHERE bountyid = 5);
INSERT INTO Guild (description, members, name, guildid)
SELECT 'A guild of thieves and rogues', 30, 'The Nightingales', 5
    WHERE NOT EXISTS (SELECT 1 FROM Guild WHERE guildid = 5);
INSERT INTO Bounty_claim (claim_date, finish_date, bounteis_bounty_id, player_id, claimid)
SELECT '2023-11-23 10:30:00', '2023-11-25 15:00:00', 1, 1, 1
    WHERE NOT EXISTS (SELECT 1 FROM Bounty_claim WHERE claimid = 1);
SELECT '2023-12-01 12:00:00', '2023-12-05 18:00:00', 2, 2, 2
    WHERE NOT EXISTS (SELECT 1 FROM Bounty_claim WHERE claimid = 2);
SELECT '2023-12-10 09:00:00', '2023-12-18 17:00:00', 3, 3, 3
    WHERE NOT EXISTS (SELECT 1 FROM Bounty_claim WHERE claimid = 3);
SELECT '2023-11-28 14:00:00', '2023-11-30 16:30:00', 4, 4, 4
    WHERE NOT EXISTS (SELECT 1 FROM Bounty_claim WHERE claimid = 4);
SELECT '2023-12-03 11:30:00', '2023-12-12 20:00:00', 5, 5, 5
    WHERE NOT EXISTS (SELECT 1 FROM Bounty_claim WHERE claimid = 5);