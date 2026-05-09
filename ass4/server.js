const io = require("socket.io")(3000);

io.on("connection", socket => {
    console.log("User: Aaryan connected");

    setInterval(() => {
        socket.emit("notification", "New Event Happened!");
    }, 3000);

    setInterval(() => {
        socket.emit("sum", Math.random() , Math.random());
    }, 4000);
});