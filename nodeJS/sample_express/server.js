var express = require('express');
var app = express();

app.get('/', function(req, res){
    res.send('My first express application');
});

app.listen(8080, function() {
    console.log('Server listening on port 8080')
});

app.post('/', function(req, res){
    res.send('Post:' + req)
});

app.all('/', function(req,res){
    console.log('All/info\n');
    res.send('ALL/info');
});

/*

Regular Expression in Path

module.exports = function(app){
    app.get(/.*\/user.*$/, function(req,res){
        res.send('User Reoute');
    });
};

*/