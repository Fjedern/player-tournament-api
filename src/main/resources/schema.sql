CREATE TABLE exercise(
  id INT PRIMARY KEY,
  tournament_id INT,
  reward_amount INT,
  player_id INT,
  player_name VARCHAR
);

CREATE TABLE players (
    id INT PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE tournaments (
    id INT PRIMARY KEY,
    name VARCHAR,
    prize INT
);

CREATE TABLE player_tournament (
    player_id INT NOT NULL,
    tournament_id INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES players(id),
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id)
);