DELETE FROM releases;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO releases (name, url, released)
VALUES ('Release_161', 'https://cloud.empyros.ru/index.php/s/R1O4PmW8Z0xBToj', '2016-03-03 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_160', 'https://cloud.empyros.ru/index.php/s/6sKfj3C8VPwmGZe', '2016-03-03 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_159', 'https://cloud.empyros.ru/index.php/s/ZsurYVseCJwGKjh', '2016-03-03 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_158', 'https://cloud.empyros.ru/index.php/s/MqvFhbsGSXOjSOo', '2016-03-02 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_157', 'https://cloud.empyros.ru/index.php/s/PL3gZfjTi2MCIbM', '2016-03-02 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_156', 'https://cloud.empyros.ru/index.php/s/MD1yXU0WaJRCU8M', '2016-02-29 00:00:00');

INSERT INTO releases (name, url, released)
VALUES ('Release_155', 'https://cloud.empyros.ru/index.php/s/PJKrYbd07N6enb3', '2016-02-27 00:00:00');

