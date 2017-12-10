var express = require('express');
var morgan = require('morgan');
var serveStatic = require('serve-static');
var bodyParser = require('body-parser');

var app = express();

var options = {
    immediate: true
};

app.use(morgan('combined', options));
app.use(serveStatic('public'));
app.use(bodyParser.json());

app.listen(8080, function(){
    console.log('Server listening on port 8080')
});