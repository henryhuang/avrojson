# avrojson

Avrojson is an avro util for convering **avro java object** to **avro-specificed json**.

[![maven][maven-image]][maven-url]
[![travis][travis-image]][travis-url]

[maven-image]: https://img.shields.io/maven-central/v/com.github.henryhuang/avrojson.svg?style=flat-square
[maven-url]: https://github.com/henryhuang/avrojson
[travis-image]: https://img.shields.io/travis/henryhuang/avrojson.svg?style=flat-square
[travis-url]: https://travis-ci.org/henryhuang/avrojson

## Dependency

``` xml

<dependency>
    <groupId>com.github.henryhuang</groupId>
    <artifactId>avrojson</artifactId>
    <version>1.8.1</version>
</dependency>

```

## Usage

``` java

	AvroDemo avroDemo = new AvroDemo();
	avroDemo.setName("AvroJson");
	avroDemo.setVersion(181);
	avroDemo.setVersionUuid("1.8.1");
	String jsonString = AvroJson.recordToJson(avroDemo, pretty);
	
```

## License

[MIT](LICENSE)

