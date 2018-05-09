# Code Vogue API Doc

Service is deployed on Heroku [Code Vogue App](https://code-vogue.herokuapp.com)

 ## Basic test score response

<table>
	<tr>
		<td>Title</td>
		<td>Get popularity of a provided term among GithHub issues</td>        
	</tr>
	<tr>
		<td>URL</td>
		<td>
			/score?term={term}</br>
			/v1/score?term={term}
		</td>
	</tr>
	<tr>
        	<td>Method</td>
        	<td>GET</td>
	</tr>
	<tr>
        	<td>URL Params</td>
        	<td>
			term=[string] [required]
		</td>
	</tr>
	<tr>
		<td>Header</td>
		<td></td>
	</tr>
	<tr>
        	<td>Success Response</td>
        	<td>
			<pre>{
	"term": "php",
	"score": 3.4168158
}</pre>
		</td>
	</tr>
	<tr>
        	<td>Demo</td>
        	<td>
			<a href="https://code-vogue.herokuapp.com/score?term=php">Heroku DEMO</a>
		</td>
	</tr>
</table>


## JsonApi.org compliant response version

<table>
	<tr>
		<td>Title</td>
		<td>
			Get popularity of a provided term among GithHub issue.<br/>
			The same as Response is JsonApi.org compliant
		</td>        
	</tr>
	<tr>
		<td>URL</td>
		<td>
			/v2/scores/{term}</br>
			/scores/{term}
		</td>
	</tr>
	<tr>
        	<td>Method</td>
        	<td>GET</td>
	</tr>
	<tr>
        	<td>URL Params</td>
        	<td>
			term=[string] [required]
		</td>
	</tr>
	<tr>
		<td>Header</td>
		<td></td>
	</tr>
	<tr>
        	<td>Success Response</td>
        	<td>
			<pre>{
	"data": {
		"type": "score",
		"id": "php",
		"attributes": {
			"score": 3.4168158
		}
	}, 
	"jsonapi": {
		"version": "2.0"
	}
}</pre>
		</td>
	</tr>
	<tr>
        	<td>Demo</td>
        	<td>
			<a href="https://code-vogue.herokuapp.com/scores/php">Heroku DEMO</a>
		</td>
	</tr>
</table>



