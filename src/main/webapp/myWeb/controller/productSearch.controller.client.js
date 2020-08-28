var searchTerm = document.getElementById('search');
    var input = '';

	const app = document.getElementById('product')
    const container = document.createElement('div')
    searchTerm.addEventListener('change', function(e) {
    	app.appendChild(container)
    	while (container.firstChild) {
    		container.removeChild(container.firstChild);
        }
    	
    	input = e.target.value; 
    	console.log("get in here")
    	console.log(input)
    	var request = new XMLHttpRequest()
        request.open('GET', 'https://zappos1.p.rapidapi.com/products/detail/api/?api_key=40325607famsh5eab662cf79d977p15a0b6jsn72b966384589&format=json&method=aj.products.search&keywords='+input, true)
        request.onload = function() {
          // Begin accessing JSON data here
          response = JSON.parse(this.response)
          console.log(response['listings']);
          //console.log(response);
          data = response.listings.listing;
          var keys = Object.keys(data);
          
          if (request.status >= 200 && request.status < 400) {
            
        	  for(var i=0;i<data.length;i++){
        		  job = data[keys[i]]
        	      const card = document.createElement('div')
        	      card.setAttribute('class', 'card')
        
        	      const detail_link = document.createElement('a')
        	      var text = document.createTextNode(product.productNumber)
        	      var number = product.number
        	      var url = product.url
        	      detail_link.setAttribute('href', "productdetail.html?number="+number+"&url="+url+"&productNumber="+product.productNumber); 

        	      /* detail_link.setAttribute('href', job.url); */ 
        	      detail_link.appendChild(text);
        	      /* detail_link.textContent = job.title */
        	
        	      const p = document.createElement('p')
        	      product.description = product.description.substring(0, 300)
        	      p.textContent = `${product.description}...`
        	
        	      container.appendChild(card)
        	      card.appendChild(detail_link)
        	      /* card.appendChild(p) */
            }
          } else {
            const errorMessage = document.createElement('marquee')
            errorMessage.textContent = `Gah, it's not working!`
            app.appendChild(errorMessage)
          }
        }

        request.send()
    }); 
    