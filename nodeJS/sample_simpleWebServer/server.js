var http = require('http');
http.createServer(function (request, response) {
    response.writeHead(200, {'content-type':'text/plain; charset=utf8'});
    var body = 'hello node.js';
    response.end(body);
}).listen(8080, '127.0.0.1');
console.log('Webserver wird ausgeführt!');