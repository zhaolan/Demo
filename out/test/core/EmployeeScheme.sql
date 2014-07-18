create table employee(
    EmployeeID char(5) primary key,
    Name varchar(20),
    TWEXP numeric(3,1)
);

create table budget(
    BudgetID varchar(10),
    EmployeeID char(8),
    Name varchar(20),
    ExpenseType varchar(100),
    CostInHomeCurrency numeric(5,1),
    ExactInfo varchar(100)
);