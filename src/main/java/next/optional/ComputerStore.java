package next.optional;

import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {
	public static final String UNKNOWN_VERSION = "UNKNOWN";
	
	public static String getVersion(Computer computer) {
		return getVersionOptional(computer);
	}
	
	public static String getVersionOptional(Computer computer) {
		return Optional.ofNullable(computer)
				.flatMap(Computer::getSoundcard)
				.flatMap(Soundcard::getUsb)
				.flatMap(USB::getVersion).orElse(UNKNOWN_VERSION);
	}
}
