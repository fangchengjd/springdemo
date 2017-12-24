package hello;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;


public class SamplePropertySource implements PropertySourceFactory{


    @Override
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {

            return  new ResourcePropertySource(encodedResource);

    }
}
