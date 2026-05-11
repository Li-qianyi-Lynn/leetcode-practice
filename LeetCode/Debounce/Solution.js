const start = Date.now();
function log() {
  console.log(Date.now() - start);
}

setTimeout(log, 10); // logs: 10
setTimeout(log, 20); // logs: 20
setTimeout(log, 50); // logs: 50
setTimeout(log, 60); // logs: 60