
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.RookyRepository;
import domain.Rooky;

@Component
@Transactional
public class StringToRookyConverter implements Converter<String, Rooky> {

	@Autowired
	private RookyRepository	rookyRepository;


	@Override
	public Rooky convert(final String text) {

		final Rooky result;
		final int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = this.rookyRepository.findOne(id);
			}

		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
