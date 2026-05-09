const io = require("socket.io-client");
const socket = io("http://localhost:3000");

socket.on("notification", msg => {
    console.log("🔔 Notification:", msg);
});

socket.on("sum", (i,j) => {
    console.log("Sum is :", i+j);
});