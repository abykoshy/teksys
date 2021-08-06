## Search Users and Tickets from json 
- Using [Spring Shell](https://spring.io/projects/spring-shell) to achieve a command line interface

 
### Libraries Used
- Jackson
- jsonpath
- Apache Commons Lang
- Lombok
- AssertJ

### Running the application

###Usage :
`search <entitytype> <criteria>`

where `<entitytype>` can be user or ticket
`<criteria>` a [jsonpath](https://support.smartbear.com/readyapi/docs/testing/jsonpath-reference.html}) expression based on the attributes

For example 

Conside a user data set :

`[
{"name":"name1","verified":true,"id": null,"created_at":null},
{"name":"name2","verified":false,"_id":"2","created_at":null},
{"name":"name1","verified":false,"_id":"3","created_at":null}
]`

a command of 

`search user "@.name == 'name1'"`

will return
 
`[
{"name":"name1","verified":true,"id": null,"created_at":null},
{"name":"name1","verified":false,"_id":"3","created_at":null}
]`

for a regular expression based search, like startswith

`search user "@.name=~/^Lo.*$/"`

will return users whose name start with "Lo"

####Note
Started off with the thought of using Java 8 streams to filter the objects. But since jsonpath library
already existed, was inclined to using it in order to handle any search.

#### More to work on
- Ensure coverage of the unit tests
- Date in result is converted to GMT, need to work on that
