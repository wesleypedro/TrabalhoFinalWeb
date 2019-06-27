$('.precoPrato').mask('#.##0,00', {reverse: true}); //, {reverse: true}
$('.cpf').mask('000.000.000-00', {reverse: true});
$('.nascimento').mask('00/00/0000');

$(document).ready(function() {  
  $('#cartModal').modal('show');
});

/*$(document).ready(function($) {
	var topoFixo = $("header").offset().top;
	$(document).scroll(function(event) {
		if(topoFixo <= $(window).scrollTop()) {
			$("header").addClass('fixo-topo');
			$("body").css({marginTop: $("header").height() + "px"});
		} else {
	    	$("header").removeClass('fixo-topo');
	    	$("body").css({marginTop: "0"});
		}
	}).trigger('scroll');
});*/