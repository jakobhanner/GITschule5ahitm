var url = 'mongodb://localhost:27017/node';
MongoClient.connect(url, function(err,db){
    var collection=db.colection('Addresses');

    db.close();
})


var address ={stret:'Limesstr', place:'Leonding', country:'Austria'};
collection.insert(address, {safe:true}, function(err,res){
    if (err) throw err;
    console.log(res);
});
collection.find({}, {_id:0}).toArray(function(err,docs){
    if (err) throw err;
    console.log(docs);
});