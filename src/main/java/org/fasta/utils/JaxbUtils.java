package org.fasta.utils;

import java.io.Reader;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JaxbUtils {

	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(Class<T> docClass, Reader inputReader)
			throws JAXBException {
		String packageName = docClass.getPackage().getName();
		return (T) unmarshal(inputReader, packageName,
				Collections.EMPTY_MAP);
	}

	private static <T> T unmarshal(Reader inputReader,
								   String packageName, Map<String, Object> properties)
			throws JAXBException {
		Unmarshaller u = createUnmarshaller(packageName, properties);
		Object o = u.unmarshal(inputReader);
		return createObjectGraph(o);
	}


	private static Unmarshaller createUnmarshaller(String packageName, Map<String, Object> properties)
			throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(packageName);
		Unmarshaller u = jc.createUnmarshaller();
		if (properties != null) {
			for (Map.Entry<String, Object> property : properties.entrySet()) {
				u.setProperty(property.getKey(), property.getValue());
			}
		}
		return u;
	}

	@SuppressWarnings("unchecked")
	private static <T> T createObjectGraph(Object o) {
		// check if it is a root element or a jaxbElement
		if (o == null) {
			return null;
		}
		if (o instanceof JAXBElement) {
			JAXBElement<T> doc = (JAXBElement<T>) o;
			return doc.getValue();
		} else {
			return (T) o;
		}
	}

	/**
	 * Serialize the Java object graph into an XML document using the UTF-8
	 * character encoding.
	 */
	public static void marshal(Object obj, Writer writer) throws JAXBException {
		marshal(obj,  writer, new HashMap<>());
	}
	
	public static void marshal(Object obj, Writer writer, Map<String, Object> properties) throws JAXBException {
		marshal(obj, writer, "UTF-8", properties);
	}

	
	private static void marshal(Object obj, Writer writer, String encoding, Map<String, Object> properties)
			throws JAXBException {
		marshal(obj, writer, encoding, false, properties);
	}


	
	@SuppressWarnings({ "rawtypes" })
	private static void marshal(Object obj, Writer writer, String encoding,
								boolean fragment, Map<String, Object> properties) throws JAXBException {
		Class clazz = null;
		if (obj instanceof JAXBElement) {
			clazz = ((JAXBElement) obj).getDeclaredType();
		} else {
			clazz = obj.getClass();
		}
		String packageName = clazz.getPackage().getName();
		marshal(obj, packageName, writer, encoding, fragment, properties);
	}

	
	


	private static void marshal(Object obj, String packageName, Writer writer,
								String encoding, boolean fragment, Map<String, Object> properties) throws JAXBException {
		final String XML_HEADER = "<?xml version=\"1.0\" encoding=\""
				+ encoding + "\"?>";

		JAXBContext jc = JAXBContext.newInstance(packageName);

		try {
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			for (Map.Entry<String, Object> property : properties.entrySet()) {
				marshaller.setProperty(property.getKey(), property.getValue());
			}
			// must manually write the XML declaration to get rid of the
			// standalone="yes" attribute inserted by the JAXB marshaller
			if (!fragment) {
				writer.write(XML_HEADER + "\n");
			}
			marshaller.marshal(obj, writer);
		} catch (Exception e) {
			throw new JAXBException(e);
		}
	}

}
