package com.rameshkp.openapi.merger.app.mergers

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.PathItem

class WebhooksMerger: MapMerger<PathItem>() {
    override fun whenKeyExists(key: String, value: PathItem) {
        val existingWebhook = map.getValue(key)
        PathItemMerger(key, existingWebhook).merge(value)
    }

    override fun get(): Map<String, PathItem> {
        val openApi = OpenAPI()
        map.forEach { (key, value) ->  openApi.addWebhooks(key, value)}
        return openApi.webhooks
    }
}
