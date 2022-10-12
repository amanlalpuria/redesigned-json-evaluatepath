package com.json.evaluatepath.resource;

import io.vertx.core.json.JsonObject;

public class EvaluatePathResource {
    public static final String CASE1 = "{\"allergyId\":\"20565\",\"allergyName\":\"insulin glulisine\",\"criticality\":\"low\",\"lastModifiedBy\":\"ptamnar\",\"lastModifiedDateTime\":\"2022-01-03T11:33:39.000Z\",\"nomenclatureId\":\"20565\",\"nomenclatureMnemonic\":\"insulin glulisine\",\"nomenclatureSource\":\"insulin glulisine\",\"onsetDateTime\":\"2015-01-08T05:00:00.000Z\",\"reactionStatus\":{\"code\":\"ACTIVE\",\"value\":\"Active\"},\"reactions\":[{\"isReactionActive\":true,\"reactionClass\":{\"code\":\"48867003\",\"value\":\"bradycardia\"},\"severity\":{\"code\":\"255604002\",\"value\":\"mild\"}}],\"severity\":{\"code\":\"0\"},\"sourceIdentifier\":\"400008\",\"sourceVocabulary\":{\"value\":\"RXNORM\"},\"timeZone\":\"America/New_York\"}";
    public static final JsonObject CASE1_MATCH_KEY = new JsonObject("{\"title\":\"Allergy\",\"description\":\"Allergy.\",\"sectionName\":\"ALLERGY\",\"idKey\":\"allergyId\",\"matchKey\":{\"description\":\"RXNORM code\",\"matchKey\":\"RXNORM\",\"operation\":\"EQUAL\",\"sourcePath\":\"sourceIdentifier\",\"targetPath\":\"sourceIdentifier\"},\"matchCodeSet\":{\"description\":\"rxnorm codeset\",\"matchKey\":\"RXNORMCODE\",\"operation\":\"LIKE\",\"sourcePath\":\"sourceVocabulary.value\",\"targetPath\":\"sourceVocabulary.value\"},\"customMatchKeys\":[{\"description\":\"Allergy nomenclature name match criteria.\",\"matchKey\":\"nomenclatureSource\",\"operation\":\"EQUAL\",\"sourcePath\":\"nomenclatureSource\",\"targetPath\":\"nomenclatureSource\"},{\"description\":\"Allergy name match criteria.\",\"matchKey\":\"allergyName\",\"operation\":\"EQUAL\",\"sourcePath\":\"allergyName\",\"targetPath\":\"allergyName\"},{\"description\":\"Clinical Concept.\",\"matchKey\":\"CLINICALCONCEPT\",\"operation\":\"EQUAL\",\"sourcePath\":\"conceptUUID\",\"targetPath\":\"conceptUUID\"}],\"targetAnnotations\":[{\"dataType\":\"DATE\",\"description\":\"To show lable as Newer\",\"label\":\"Newer\",\"operation\":\"GREATER\",\"sourcePath\":\"lastModifiedDateTime\",\"targetPath\":\"createdDateTime\",\"insightTemplate\":\"Newer record <strong>$allergyName$</strong> with $reactionStatusvalue$REACTION_LIST, $reactionsnomenclatureSourceString$SEVERITY_VALUE, $severityvalue$ONSET_DATE_TIME $onsetDateTime$ is available from $tenantName$\"},{\"dataType\":\"LIST\",\"description\":\"To show lable as Important\",\"label\":\"Important\",\"operation\":\"NOTEQUAL\",\"sourceListPath\":\"reactions\",\"targetListPath\":\"reactions\",\"sourcePath\":\"reactionClass.code\",\"targetPath\":\"reactionClass.code\",\"insightTemplate\":\"Different Reaction $reactionsnomenclatureSourceString$ has been recorded for <strong>$allergyName$</strong> in $tenantName$\"},{\"dataType\":\"STRING\",\"description\":\"To show lable as Important\",\"label\":\"Important\",\"operation\":\"GREATER\",\"sourcePath\":\"criticality\",\"targetPath\":\"criticality\",\"insightTemplate\":\"Different criticality $criticality$ has been recorded for <strong>$allergyName$</strong> in $tenantName$\"},{\"description\":\"To show lable as Gap, if record is not present in source ehr, only latest record will be labeled as gap\",\"label\":\"Gap\",\"operation\":\"GREATER\",\"targetPath\":\"createdDateTime\",\"dataType\":\"DATE\",\"displayKeyPath\":\"allergyName\",\"insightTemplate\":\"This allergy is missing in athena:\",\"insightTemplatePlural\":\"These allergies are missing in athena:\"}],\"insights\":{\"dataKeys\":[{\"dataKey\":\"allergyName\"},{\"dataKey\":\"criticality\"},{\"dataKey\":\"reactionStatus.value\"},{\"dataType\":\"LIST\",\"dataKey\":\"reactions.nomenclatureSourceString\",\"insightTextMatcherKey\":\"REACTION_LIST\"},{\"dataKey\":\"severity.value\",\"insightTextMatcherKey\":\"SEVERITY_VALUE\"},{\"dataKey\":\"createdDateTime\",\"dataType\":\"DATE\"},{\"dataKey\":\"onsetDateTime\",\"dataType\":\"DATE\",\"insightTextMatcherKey\":\"ONSET_DATE_TIME\"}]}}");
    public static final JsonObject CASE1_MATCH_CODE_SET = new JsonObject("{\"description\":\"rxnorm codeset\",\"matchKey\":\"RXNORMCODE\",\"operation\":\"LIKE\",\"sourcePath\":\"sourceVocabulary.value\",\"targetPath\":\"sourceVocabulary.value\"}");
    public static final String CASE1_SOURCE_KEY_EXPECTED ="400008";
    public static final String CASE1_SOURCE_CODESET_VALUE_EXPECTED = "RXNORM";
}
