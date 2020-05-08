import csv

with open("e:/demo/Emp.csv", mode="r") as csv_file:
    reader = csv.DictReader(csv_file)
    line_count = 0
    for row in reader:
        print(row)
