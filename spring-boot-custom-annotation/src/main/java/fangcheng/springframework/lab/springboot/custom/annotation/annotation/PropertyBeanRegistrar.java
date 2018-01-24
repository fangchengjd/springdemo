package fangcheng.springframework.lab.springboot.custom.annotation.annotation;

import fangcheng.springframework.lab.springboot.custom.annotation.Bean.SimpleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import sun.reflect.annotation.AnnotationType;

import java.util.Map;
import java.util.Properties;

public class PropertyBeanRegistrar  implements ImportBeanDefinitionRegistrar
{

    private  final  Logger logger =LoggerFactory.getLogger(PropertyBeanRegistrar.class);

    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link } types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     *
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        String annoName = PropertyBean.class.getCanonicalName();
        Map<String, Object> attrs = importingClassMetadata.getAnnotationAttributes(annoName);

        logger.info(importingClassMetadata.toString());
        logger.info("Attributes" + attrs);

        logger.info(importingClassMetadata.getAnnotationTypes().toString());

        String attr_name = attrs.get("name").toString();
        String attr_location = attrs.get("location").toString();


        // register factory bean, still need to be investigation
        GenericBeanDefinition factoryBeanDefinition = new GenericBeanDefinition();
        factoryBeanDefinition.setBeanClass(PropertiesFactoryBean.class);

        PropertyValue pv = new PropertyValue("location", attr_location);

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue(pv);

        factoryBeanDefinition.setPropertyValues(mutablePropertyValues);

        registry.registerBeanDefinition(PropertiesFactoryBean.class.getCanonicalName(), factoryBeanDefinition);

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Properties.class);
        beanDefinition.setFactoryBeanName(PropertiesFactoryBean.class.getCanonicalName());

        registry.registerBeanDefinition("InsideProperties", beanDefinition);

        /// simple bean
        GenericBeanDefinition  simpleBeanDef  = new GenericBeanDefinition();
        simpleBeanDef.setBeanClass(SimpleBean.class);

        MutablePropertyValues simpleBeanPropertyValues = new MutablePropertyValues();
        simpleBeanPropertyValues.add("location", attr_location);

        simpleBeanDef.setPropertyValues(simpleBeanPropertyValues);
        registry.registerBeanDefinition(attr_name, simpleBeanDef);


    }

}
