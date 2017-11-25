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

	var $table=$("#productListTable");
	//excecute the below code only when we have this table	
	if($table.length){
		//console.log('Inside the table!');
		
		var jsonUrl='';
		if(window.categoryId==''){
			jsonUrl=window.contextRoot+'/json/data/all/products';
			}
		else{
			jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		console.log(jsonUrl);
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 RECORDS','5 RECORDS','10 RECORDS','ALL']],
			pageLength:5,
			ajax:{
				url: jsonUrl,
				dataSrc :''
			},
			columns:[
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data:'unitPrice',
					mRender:function(data,type,row){
						return '&#8377; '+data
					}
				},
				{
					data:'quantity'
				},
				{
					data:'id',
					bSortable:false,
					mRender:function(data,type,row){
						var str='';
						str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span> </a> &#160;';
						str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
						return str;
					}
				}
			]
		});
	}
	
	
});