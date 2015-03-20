<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>

	<xsl:template match="/">
	    <javancss>
	    <xsl:message>match: root</xsl:message>
	    <xsl:apply-templates select="javancss/objects/object"/>
	    </javancss>
	</xsl:template>

	<xsl:template match="object">
		<xsl:message>match: object</xsl:message>
	    <xsl:element name="class">
	    	<xsl:attribute name="name">
	    		<xsl:value-of select="name/text()"/>
	    	</xsl:attribute>
	    	<xsl:attribute name="methods">
	    		<xsl:value-of select="functions/text()"/>
	    	</xsl:attribute>
	    	<xsl:attribute name="ncss">
	    		<xsl:value-of select="ncss/text()"/>
	    	</xsl:attribute>
	    	<xsl:attribute name="javadocs">
	    		<xsl:value-of select="javadocs/text()"/>
	    	</xsl:attribute>
	    </xsl:element>
	</xsl:template>
</xsl:stylesheet>