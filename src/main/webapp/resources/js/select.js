$( function() {
		$(".buttonGroup").buttonGroupLogic();
});

(function ( $ ) {
    
    $.fn.buttonGroupLogic = function() {
        "use strict";
   
	    this.find(".buttonGroup-button").click(function(){
	  	
	  		var button = $(this);
	  		
	  		if(button.hasClass("selected")){
				deselectButton(button);
			}else{
				selectButton(button);
			}
			
			function deselectButton(obj){
		
				var group = obj.data('buttongroup');
		    	
		    	if(isNaN(group)){
		    	
		    		// selection can be made within a single group
					if(obj.parent().siblings().find(".buttonGroup-button.selected[data-buttonGroup=" + group + "]").size() < 1){
						obj.parent().siblings().find(".buttonGroup-button:not([data-buttonGroup=" + group + "])").removeClass("disabled");
					}
					
				}else{
				
					// buttons within groups are mutually exclusive
					obj.parent().siblings().find(".buttonGroup-button[data-buttonGroup=" + group + "]").removeClass("disabled");
				}
				obj.removeClass("selected");
			}
			
			function selectButton(obj) {
			
				var group = obj.data('buttongroup');
				
				if(isNaN(group)){
				
					// selection can be made within a single group
					obj.parent().siblings().find(".buttonGroup-button[data-buttonGroup=" + group + "]").removeClass("disabled");
					obj.parent().siblings().find(".buttonGroup-button:not([data-buttonGroup=" + group + "])").removeClass("selected").addClass("disabled");
					
				}else{
				
					// buttons within groups are mutually exclusive
					obj.parent().siblings().find(".buttonGroup-button[data-buttonGroup=" + group + "]").addClass("disabled").removeClass("selected");
					
				}
				obj.removeClass("disabled").addClass("selected");
			}
		});
		
		return this;
    }
 	
}( jQuery ));