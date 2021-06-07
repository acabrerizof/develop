DROP TABLE IF EXISTS Detalle;
DROP TABLE IF EXISTS Ticket;

CREATE TABLE Ticket (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  total_amount int NOT NULL DEFAULT 0
);

CREATE TABLE Detalle (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_ticket int not null,
  description varchar2(100),
  total_amount int NOT NULL DEFAULT 0,
  FOREIGN KEY (id_ticket) REFERENCES Ticket(id)
);

/*INSERT INTO Ticket (total_amount) VALUES
  (10),
  (20),
  (30);
  
INSERT INTO Detalle (id_ticket, description, total_amount) VALUES
	(1, 'Description 1.1', 10),
	(1, 'Description 1.2', 20),
	(2, 'Description 2.1', 50),
	(3, 'Description 3.1', 70),
	(3, 'Description 3.2', 100);
*/