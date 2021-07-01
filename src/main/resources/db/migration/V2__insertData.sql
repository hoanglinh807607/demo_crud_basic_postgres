INSERT INTO role(code,name) VALUES
('admin','Admin'),
('user','User'),
('adminall','Admin All');

INSERT INTO account(username, password, fullname, phone, address) VALUES
('user123','$2a$10$PxsA8JM/mCL/8XNwCdBTM.NNzTzzSnjfvj9PjBjPvUZDhqjjO9o/6','nguyen van b','0973697807','Xuân khánh, Ninh Kiều, Cần Thơ'),
('admin123','$2a$10$/pDwooKldgy.fgibb1iVUeB2SgoZUabifDGl1sBdFcSPyO/x4hbhq','nguyenvana','0973697807','nguyenvana'),
('admin111','$2a$10$cvqh1X5MAIfExiJ7e.I5L.3BI9baa5iZna00BRYsb5O/GKRj5d7z.','Nguyễn Văn C','0939999000','Nguyễn Văn C');

INSERT INTO account_role(account_id,role_id) VALUES
(1,1),
(1,2),
(2,1),
(3,1);