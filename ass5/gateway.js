const express = require("express");
const axios = require("axios");
const app = express();

app.get("/dashboard", async (req, res) => {
    const user = await axios.get("http://localhost:3001/user");
    const order = await axios.get("http://localhost:3002/order");

    res.json({
        user: user.data,
        order: order.data
    });
});

app.listen(3000, () => console.log("API Gateway running"));