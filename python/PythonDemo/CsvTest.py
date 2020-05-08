import csv

with open("e:/demo/Emp_Modify.csv", mode="r") as csv_file:
    reader = csv.reader(csv_file, delimiter='#')
    line_count = 0
    for row in reader:
        print(row)
