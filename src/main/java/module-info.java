module dev.jab125.discordsocialsdk {
	requires org.jetbrains.annotations;
	requires java.base;
	exports dev.jab125.discordsocialsdk.api;
	opens dev.jab125.discordsocialsdk.impl;
}