select product_name from orders
join customers on customers.id = orders.customer_id
where lower(customers.name) = lower(:name);