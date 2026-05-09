const express = require("express");
const app = express();

app.get("/user", (req, res) => {
    res.json({ id: 1, name: "Aaryan Bairagi" });
});

app.listen(3001, () => console.log("User Service running"));