package common

import java.text.Normalizer
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 30/06/11
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
class NameNormalizer {

    def static Normalize(String name){
        def normalizedName

        //Replace accent characters
        normalizedName = Normalizer.normalize(name, Normalizer.Form.NFD)
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        normalizedName = pattern.matcher(normalizedName).replaceAll("")

        //Use regex to remove the punctuation and spaces
        normalizedName = normalizedName.replaceAll("'", "")
        normalizedName = normalizedName.replaceAll("\\s+", "-")
		normalizedName = normalizedName.replaceAll("/", "-")
        return normalizedName.toLowerCase()
    }
}
