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

	//code for datatables
	//create a dataset
	var products=[
['1','ABC'],
['2','XYZ'],
['3','PQR'],
['4','MNO'],
['5','WVB'],
['6','CFG'],
['7','HIK'],
['8','LMP'],
		
		
	];
	var $table=$("#productListTable");
	//excecute the below code only when we have this table	
	if($table.length){
		//console.log('Inside the table!');
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 RECORDS','5 RECORDS','10 RECORDS','ALL']],
			pageLength:5,
			data:products
		});
	}
	
	
});