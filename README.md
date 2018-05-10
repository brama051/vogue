# Code Vogue API Doc

Service is deployed on Heroku [Code Vogue App](https://code-vogue.herokuapp.com)

 ## Basic test score response

<table>
	<tr>
		<td>Title</td>
		<td>Get popularity of a provided term among GithHub issues. Note: This endpoint is not protected and can be consumed without any sort of credentials</td>        
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
		<td>none</td>
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


## JsonApi.org compliant request path and response version

<table>
	<tr>
		<td>Title</td>
		<td>
			Get popularity of a provided term among GithHub issue.<br/>
			The same as Response is JsonApi.org compliant<br/>
			Important: This endpoint is protected and  in order to get authorizied,<br/>
			you must provide a JWT in the request header. Example of fetching a token via CURL (the JWT will be in access_token attribute):
			<pre>curl --request POST \
  --url https://hearthum.eu.auth0.com/oauth/token \
  --header 'content-type: application/json' \
  --data '{"client_id":"Git1f3eV6DlZjv17Ms724kyfOYzHcm91","client_secret":"fRplqSgWd8KNOfFksn3szn0xbApRKCjMqCChY68BylE96SqdI_cRebmG01D6pmat","audience":"https://code-vogue.herokuapp.com","grant_type":"client_credentials"}'</pre>
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
		<td>Authorization:Bearer {this is where previously fetched JWT token should be}</td>
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
			<a href="https://code-vogue.herokuapp.com/scores/php">Heroku DEMO</a> <- Won't work without Authorization header!
		</td>
	</tr>
</table>



