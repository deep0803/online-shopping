$(function() {
	switch (menu) {
	case 'About Us Page':
		$("#about").addClass('active');
		break;
	case 'Service Page':
		$("#service").addClass('active');
		break;
	case 'contact Page':
		$("#contact").addClass('active');
		break;
	case 'Home Page':
		$("#homePAge").addClass('active');
		break;
	case 'All Products':
		$("#listProducts").addClass('active');
		break;
	default:
		$("#listProducts").addClass('active');
		$("#a_"+menu).addClass('active');
		break;
	}

});