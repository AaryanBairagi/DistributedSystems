const express = require("express");
const app = express();

app.get("/order", (req, res) => {
    res.json({ orderId: 101, item: "Laptop" });
});

app.listen(3002, () => console.log("Order Service running"));