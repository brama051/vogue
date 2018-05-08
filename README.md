# Code Vogue API Doc

Service is running on Heroku [Code Vogue App](https://code-vogue.herokuapp.com)

## Basic test score

`GET /score?term=php` or `GET /v1/score?term=php` [DEMO](https://code-vogue.herokuapp.com/score?term=php)

```json
{
	"term": "php",
	"score": 3.4168158
}
```

## JsonApi.org compliant version

`GET /scores/php` or `GET /v1/scores/php` [DEMO](https://code-vogue.herokuapp.com/scores/php)

```json
{
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
}
```



