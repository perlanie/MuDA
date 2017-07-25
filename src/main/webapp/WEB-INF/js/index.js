$("#select").selectize({
  create: true,
  maxItems: 100,
  onType: function (str) {
    if (str.indexOf("at") != -1) {
      var beforeAt = str.substr(0, str.indexOf("at"));
      this.createItem(capitalizeFirstLetter(beforeAt))
    }
    
  },
  score: function(search) {

      if (search.indexOf("at") != -1) {
        search = search.substr(search.indexOf("at") + 3, search.length);
        var score = this.getScoreFunction(search);
        return function(item) {
          return score(item)
        };
      } else {
        return function(item) {
          return 0;
        };
      }

    }
})

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}