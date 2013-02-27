<html>

<head>
 <script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
 
 <script type="text/javascript">
     var jq = jQuery.noConflict();
 </script>
<script type="text/javascript">

	function add() {
		jq(function() {
			jq.ajax({
				type : 'GET',
				url : '/mvc/json',
				data : {
					get_param : 'value'
				},
				dataType : 'json',
				success : function(data) {
					
					jq('#error').html('');
					
					var size = jq('#list > div').size();
					var mySecondDiv = jq('<div id="movie'+ size +'">'
							+ data.name + '</div>');
					if (parseInt(size) <= 9) {
						var mySecondDiv = jq('<div id="movie'+ size +'">'
								+ data.name + '</div>');
						jq('#list').append(mySecondDiv);
					} else {
						jq('#list').find('div').first().remove();
						jq('#list').append(mySecondDiv);
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					jq('#error').html('Internal Server Error');
				}
			});
		});
	}
</script>
</head> 
<body>
	
<table>
    <tr>
     <input type="submit" name="ClickMe" id="clickme" value="ClickMe" onclick="add()" style="color:Blue;"/>
     <div id="error" style="color:Blue;background-color: red"></div>
	 <div id="title" style="font-size: 20px;font-weight: bold;">Movie Title</div>
     <div id="list"></div>
    </tr>
    
</table>  
</body>
</html>