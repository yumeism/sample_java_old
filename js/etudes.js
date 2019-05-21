$(function() {

	// 郵便番号の取得
	$('#postBtn').click(function(){

 		var zipcode = $('#post').val();

 		if(zipcode.length != 7){
 			return;
 			
 		}else {
 			$.getJSON(
 				 'http://zipcloud.ibsnet.co.jp/api/search?callback=?'
	 				,{zipcode : zipcode}
	 				,function writeAddressByZipcloud(response) {

	 					if(response.status != 200) {
 							return false;
 						}
 						if(!response.results) {
						return false;
					}

					var addr = response.results[0].address1 + response.results[0].address2;

				// 結果が１つの場合は、町域名まで含める
					if(response.results.length == 1) {
						addr += response.results[0].address3;
					}
				
					$('#addr').val(addr);
				}
			);
		}
	});

// 緯度経度取得
	$('#addr').change(function(){
	// 住所の取得
		var addr = $('#addr').val();

		if(addr == "" ){
			return;
		}

		var geocoder = new google.maps.Geocoder();

		geocoder.geocode(
			{ 'address': addr, 'region' : 'jp' },
			
			function(results, status) {
		        if (status == google.maps.GeocoderStatus.OK) {
		        	var latlng = results[0].geometry.location;
					$('#lat').val(latlng.lat());
					$('#lng').val(latlng.lng());
		        }
	        }
		);
	});

});