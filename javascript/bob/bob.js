module.exports = function(){
  this.hey = function(statement){
    if(statement.match(/^\s*$/))
      return "Fine. Be that way!";
    else if(statement === statement.toUpperCase() && statement.match(/[a-zA-Z]/))
      return "Woah, chill out!";
    else if(statement.match(/\?$/))
      return "Sure.";
    else
      return "Whatever.";
  };
};
