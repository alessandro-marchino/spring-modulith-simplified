INSERT INTO inventory (description, name, price)
SELECT tmp.description, tmp.name, tmp.price
FROM (VALUES
	('for writing','pencil', 50000, 1),
	('for ruling','ruler', 10000, 2),
	('for taking notes','notebook', 60000,3),
	('for drawing','drawing_pad', 70000, 4),
	('for packing lunch','lunchbox', 80000,5)
) AS tmp(description, name, price, ord)
WHERE NOT EXISTS (
	SELECT 1
	FROM inventory
	WHERE inventory.name = tmp.name
)
ORDER BY tmp.ord;